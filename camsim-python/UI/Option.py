from Body.Buttons import *
from Process.OBJECTS import *

def showAvailableOptions():

    showBATTERYops()
    showCARDops()
    showLENSops()

    showPOWERops()
    showBUTTONops()
    showDIALops()


def showPOWERops():
    pass

def showLENSops():
    pass

def showBATTERYops():
    # if
    pass

def showCARDops():
    pass

def showBUTTONops():
    pass


def showDIALops():
    if bISO.getstate(): #ISO pressed
        print("Change ISO -> trigger Front Dial")
    else:
        print("Change Aperture -> trigger Front Dial")
        print("Change Shutter Speed -> trigger Back Dial")




