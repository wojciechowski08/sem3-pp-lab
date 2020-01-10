from Process.OBJECTS import oShutter


def openShutter():
    if not oShutter.getEnclosureState():
        oShutter.setEnclosureState(1)
    else:
        pass
        # shutter already opened


def closeShutter():
    if oShutter.getEnclosureState():
        oShutter.setEnclosureState(0)
    else:
        pass
        # shutter already closed


def openForCapturing():
    if not oShutter.getState():
        if oShutter.getEnclosureState():
            oShutter.setEnclosureState(0)
        oShutter.setState(1)
        oShutter.setEnclosureState(1)
    else:
        pass
        # shutter occupied


def closeFromCapturing():
    if oShutter.getState():
        oShutter.setEnclosureState(0)
        oShutter.setState(0)
        oShutter.setEnclosureState(1)
    else:
        pass
        # shutter was not opened for capturing
