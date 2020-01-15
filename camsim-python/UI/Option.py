from Body.Buttons import *
from Process.CPU import calculateExposure
from Process.OBJECTS import *
from typing import List


def showCameraState():

    displayPrint = ""

    if oCard.getState() == 1:
        displayPrint += "CARD IS IN CAMERA\n"
    else:
        displayPrint += "CARD IS NOT IN CAMERA\n"
    if oLens.getState() == 1:
        displayPrint += "LENS IS ON BODY\n"
    else:
        displayPrint += 'LENS IS NOT ON BODY\n'
    if oBattery.getState() == 1:
        displayPrint += 'BATTERY IS IN CAMERA\n'
    else:
        displayPrint += 'BATTERY NOT IN BODY\n'
    if oBody.getState():
        displayPrint += "CAMERA IS ON\n"
        displayPrint += "-----------------\n" \
                        "CURRENT SETTINGS\n"
        # displayPrint += "Mode " + str(getCurrentShootingMode()) + " "
        displayPrint += "SS " + str(oShutter.getCurrentSS()) + " "
        displayPrint += "Aperture " + str(oAperture.getCurrentAperture()) + " "
        displayPrint += "ISO " + str(oSensor.getISO()) + "\n"
        # displayPrint += "Focusing " + str(getCurrentFocusingMode())
        # if getCurrentFocusingMode() == "AF":
        #     displayPrint += str(getCurrentAFMode())
        # displayPrint += "\n"
        displayPrint += "Metering " + str(oBody.getFacingLight()) + "\n" +\
                        "Exposure " + str(calculateExposure(oSensor.getISO(), oShutter.getCurrentSS(), oAperture.getCurrentAperture())) + " "
        # displayPrint += "+/- " + str(getCurrentExposureCompensation()) + "\n"
        # displayPrint += "Metering mode " + str(getCurrentMeteringMode()) + "\n"
        # displayPrint += "White Balance " + str(getCurrentWhiteBalance()) + "\n"
        # displayPrint += "Image Quality " + str(getCurrentFileFormat())
        # if getCurrentFileFormat() in ["JPG", "RAW + JPG"]:
        #     displayPrint += " " + str(getCurrentJPGQuality())
        displayPrint += "\n-----------------"
    else:
        displayPrint += "CAMERA IS OFF"

    print(displayPrint)


#     displayPrint += "-----------------\n" \
#                     "CURRENT SETTINGS\n"
#     displayPrint += "Mode " + str(getCurrentShootingMode()) + " "
#     displayPrint += "SS " + str(getCurrentShutterSpeed()) + " "
#     displayPrint += "Aperture " + str(getCurrentAperture()) + " "
#     displayPrint += "ISO " + str(getCurrentISO()) + "\n"
#     displayPrint += "Focusing " + str(getCurrentFocusingMode())
#     if getCurrentFocusingMode() == "AF":
#         displayPrint += str(getCurrentAFMode())
#     displayPrint += "\n"
#     displayPrint += "Exposure " + str(getCurrentExposure()) + \
#                     " " + str(showCurrentExposure()) + " "
#     displayPrint += "+/- " + str(getCurrentExposureCompensation()) + "\n"
#     displayPrint += "Metering mode " + str(getCurrentMeteringMode()) + "\n"
#     displayPrint += "White Balance " + str(getCurrentWhiteBalance()) + "\n"
#     displayPrint += "Image Quality " + str(getCurrentFileFormat())
#     if getCurrentFileFormat() in ["JPG", "RAW + JPG"]:
#         displayPrint += " " + str(getCurrentJPGQuality())
#


def checkAvailableOptions() -> List[str]:
    options = []
    # 'ins b' or 'insert battery'
    # 't out b' or 'take out battery'
    # 'ch b' or 'change battery'
    options.extend(checkBATTERYoptions())
    options.extend(checkCARDoptions())
    options.extend(checkLENSoptions())
    if not 'ins b' in options:
        options.extend(checkPOWERoptions())
        options.extend(checkBUTTONoptions())
        options.extend(checkDIALoptions())

    return options


def showAvailableOptions(options: List[str]):
    d = {'ins b': 'Insert the battery',
         't out b': 'Take out the battery',
         'ch b': 'Change the battery',
         'ins c': 'Insert the card',
         't out c': 'Take out the card',
         'ch c': 'Change the card',
         'p on l': 'Put on the lens',
         't off l': 'Take off the lens',
         'sw off': 'Switch off',
         'sw on': 'Switch on',
         'p iso': 'Press ISO button',
         'up iso': 'Unpress ISO button',
         'p menu': 'Press Menu button',
         'p gallery': 'Press Gallery button',
         'p info': 'Press Info button',
         'p l': 'Press Left Arrow button',
         'p r': 'Press Right Arrow button',
         'hp sb': 'Halfpress Shutter button',
         'p sb': 'Press Shutter button',
         'up sb': 'Unpress Shutter button',
         't fd p': 'Trigger Front Dial positively',
         't fd n': 'Trigger Front Dial negatively',
         't bd p': 'Trigger Back Dial positively',
         't bd n': 'Trigger Back Dial negatively',
         'move' : 'Move the camera'
         }
    for o in options:
        print("Type '" + o + "' to " + d[o])


def checkPOWERoptions() -> List[str]:
    options = []
    if oBody.getState():
        options.append('sw off')
    else:
        options.append('sw on')
    return options


def checkLENSoptions() -> List[str]:
    options = []
    if not oLens.getState():
        options.append('p on l')
    else:
        options.append('t off l')
    return options


def checkBATTERYoptions() -> List[str]:
    options = []
    if not oBattery.getState():  # if battery is out
        options.append('ins b')
    else:
        options.append('t out b')
        options.append('ch b')
    return options


def checkCARDoptions() -> List[str]:
    options = []
    if not oCard.getState():
        options.append('ins c')
    else:
        options.append('t out c')
        options.append('ch c')
    return options


def checkBUTTONoptions() -> List[str]:
    options = []
    if oBody.getState():  # if camera is on
        if bISO.getState():
            options.append('up iso')
        else:
            options.append('p iso')
        options.append('p menu')
        options.append('p gallery')
        if oBody.getMode() == 'gallery':
            options.append('p l')
            options.append('p r')
            options.append('p info')
        elif oBody.getMode() == 'lv':
            if bSHUTTER.getState() == 0:
                options.append('hp sb')
            elif bSHUTTER.getState() == 1:
                options.append('p sb')
                options.append('up sb')
                # implement check for focusing mode
    return options


def checkDIALoptions() -> List[str]:
    options = []
    if oBody.getState():
        if oBody.getMode() == 'lv':
            if bISO.getState():  # ISO pressed
                if oSensor.getISO() == oSensor.getMinISO():
                    options.append('t fd p')
                elif oSensor.getISO() == oSensor.getMaxISO():
                    options.append('t fd n')
                else:
                    options.append('t fd p')
                    options.append('t fd n')
                # print("Change ISO -> trigger Front Dial")
            else:
                if oAperture.getCurrentAperture() == oLens.getMinAperture():
                    options.append('t fd p')
                elif oAperture.getCurrentAperture() == oLens.getMaxAperture():
                    options.append('t fd n')
                else:
                    options.append('t fd p')
                    options.append('t fd n')
                if oShutter.getCurrentSS() == oShutter.getFastestSpeed():
                    options.append('t bd p')
                elif oShutter.getCurrentSS() == oShutter.getLongestSpeed():
                    options.append('t bd n')
                else:
                    options.append('t bd p')
                    options.append('t bd n')

                # print("Change Aperture -> trigger Front Dial")
                # print("Change Shutter Speed -> trigger Back Dial")
    return options
