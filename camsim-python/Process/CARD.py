import time

from File.Photo import Photo
from Process.OBJECTS import oCard


def CputIN():
    oCard.setState(1)


def CpullOUT():
    oCard.setState(0)


def Cchange() -> bool:
    if oCard.getState():
        # change and come to same card option for further dev
        oCard.setState(0)
        oCard.setUsedSpace(0)
        oCard.setState(1)
        return True
    else:
        return False


def CwriteToCard(photo: Photo):
    if oCard.getState():
        if not oCard.getUsageState():
            oCard.setInUsageState(1)
            if oCard.write(photo):
                # writing file to card promp
                time.sleep(photo.size / oCard.getWriteSpeed())
                # saved
            else:
                pass
                # not enough space promp
            oCard.setInUsageState(0)
        else:
            pass
            # info about busy card
    else:
        pass
        # info about empty card slot


def CreadFromCard(currentPhoto=0):
    if oCard.getState():
        if not oCard.getUsageState():
            oCard.setInUsageState(1)
            temp = oCard.read("Photo", currentPhoto)
            time.sleep(temp.size / oCard.getReadSpeed())
            # show info about photo
            oCard.setInUsageState(0)
            return temp.showPhoto()
        else:
            pass
            # info about busy card
    else:
        pass
        # info about empty card slot


def CremovePhoto(currentPhoto=0):
    if oCard.getState():
        if not oCard.getUsageState():
            oCard.setInUsageState(1)
            oCard.delete("Photo", currentPhoto)
            time.sleep(0.2)
            oCard.setInUsageState(0)
        else:
            pass
            # info about busy card slot
    else:
        pass
        # info about empty card slot
