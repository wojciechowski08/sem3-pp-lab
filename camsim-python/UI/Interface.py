from Process.CPU import takeAPhoto, showGallery, nextPhoto, previousPhoto
from Process.POWER import TURNON, TURNOFF
from UI.Option import *
from Process.OBJECTS import *
from Process.BATTERY import *
from Process.CARD import *
from Process.LENS import *
from Body.Buttons import *


def openUI():

    while True:

        showCameraState()
        print("Enter 'bye' to kill the program.")
        options = checkAvailableOptions()
        showAvailableOptions(options)
        userInput = input("Choose one of the available options.\n")

        if userInput == "bye":
            break
        elif userInput in options:
            if userInput == 'ins b':
                BputIN()
            elif userInput == 't out b':
                BpullOUT()
            elif userInput == 'ch b':
                Bchange()
            elif userInput == 'ins c':
                CputIN()
            elif userInput == 't out c':
                CpullOUT()
            elif userInput == 'ch c':
                Cchange()
            elif userInput == 'p on l':
                LputON()
            elif userInput == 't off l':
                LtakeOFF()
            elif userInput == 'sw on':
                TURNON()
            elif userInput == 'sw off':
                TURNOFF()
            elif userInput == 'p iso':
                bISO.hold()
            elif userInput == 'up iso':
                bISO.unpress()
            elif userInput == 'p menu':
                if oBody.getMode() == 'menu':
                    oBody.setMode('lv')
                else:
                    oBody.setMode('menu')
            elif userInput == 'p gallery':
                if oBody.getMode() == 'gallery':
                    oBody.setMode('lv')
                else:
                    oBody.setMode('gallery')
                    showGallery()
            elif userInput == 'p info':
                pass # IMPLEMENT LATER
            elif userInput == 'p l':
                previousPhoto()
            elif userInput == 'p r':
                nextPhoto()
            elif userInput == 'hp sb':
                bSHUTTER.hold()
            elif userInput == 'p sb':
                takeAPhoto(oSensor.getISO(), oShutter.getCurrentSS(), oAperture.getCurrentAperture())
            elif userInput == 'up sb':
                bSHUTTER.unpress()
            elif userInput == 't fd p':
                if bISO.getState():
                    oSensor.setISO(oSensor.getISO()*2)
                else:
                    oAperture.setCurrentAperture(oAperture.getApertureTable()[oAperture.getApertureTable().index(oAperture.getCurrentAperture())-1])
            elif userInput == 't fd n':
                if bISO.getState():
                    oSensor.setISO(oSensor.getISO()/2)
                else:
                    oAperture.setCurrentAperture(oAperture.getApertureTable()[oAperture.getApertureTable().index(oAperture.getCurrentAperture())+1])
            elif userInput == 't bd p':
                oShutter.setSpeed(oShutter.getCurrentSS()*2)
            elif userInput == 't bd n':
                oShutter.setSpeed((oShutter.getCurrentSS()/2))
            elif userInput == 'move':
                oBody.move()

        else:
            print("Unrecognized action.")

