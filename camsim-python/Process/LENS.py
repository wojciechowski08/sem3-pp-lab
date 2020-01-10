from Process.OBJECTS import oLens, oAperture


def putON():
    oLens.setState(1)


def takeOFF():
    oLens.setState(0)


def encloseAperture():
    if oLens.getState():
        if not oAperture.getState():
            oAperture.setState(1)
        else:
            pass
            # already enclosed = in usage
    else:
        pass
        # cant enclose, lens not put on


def reopenAperture():
    if oAperture.getState():
        oAperture.setState(0)
    else:
        pass
        # already opened = ready to use

