# ev values from -15.0 to 20.0

# EV = log2(N2 / t) where N = f-number and t = exposure time in seconds.
# EVS = EV100 + log2(S / 100) where S = desired ISO.
import math

from File.Photo import Photo
from Process.CARD import CwriteToCard, CreadFromCard
from Process.OBJECTS import *
from Process.LENS import *
from Process.SENSOR import *
from Process.SHUTTER import *


def calculateExposure(ISO: int, SS: float, A: float) -> float:
    return math.log(1 / A * A / SS, 2) + math.log(ISO / 100, 2)


def takeAPhoto(ISO, SS, A):
    if oBody.getState():
        if oLens.getState():
            if oCard.getState():

                if oSensor.getState() == 0:
                    if oShutter.getState() == 0:
                        if oCard.getUsageState() == 0:

                            LencloseAperture()
                            SHopenForCapturing()
                            data = ScapturePhoto()
                            SHcloseFromCapturing()
                            LreopenAperture()
                            photo = Photo('1', 'jpg', 30, '20200114')
                            photo.setData(data)
                            CwriteToCard(photo)
                            print("PHOTO TAKEN")
                            return True
                        else:
                            print("CARD IN USAGE, CAN'T CAPTURE")
                            pass  # card is in usage
                    else:
                        print("SHUTTER IS BUSY, CAN'T CAPTURE")
                        pass  # shutter is taking a photo
                else:
                    print("SENSOR IS BUSY, CAN'T CAPTURE")
                    pass  # sensor is busy

            else:
                print("CARD IS NOT IN, CAN'T CAPTURE")
                pass
                # card is not in
        else:
            print("LENS NOT ON BODY, CAN'T CAPTURE")
            pass
            # lens is not on
    else:
        print("CAMERA TURNED OFF, CAN'T CAPTURE")
        pass
        # camera is turned off


def showGallery(index=0):
    if oBody.getState():
        if oCard.getState():
            if oCard.getUsageState() == 0:
                oBody.setMode('gallery')
                print(CreadFromCard(index))
            else:
                print("CARD IN USAGE, CAN'T SHOW GALLERY")
                pass
                # card in usage
        else:
            print("CARD IS NOT IN, CAN'T SHOW GALLERY")
            pass
            # card is not in
    else:
        print("CAMERA IS OFF, CAN'T SHOW GALLERY")
        pass
        # camera is turned off

def nextPhoto():
    showGallery(index=1)
def previousPhoto():
    showGallery(index=0)
