from Process.OBJECTS import oLens, oAperture


def LputON():
    oLens.setState(1)


def LtakeOFF():
    oLens.setState(0)


def LencloseAperture():
    if oLens.getState():
        if not oAperture.getState():
            oAperture.setState(1)
        else:
            pass
            # already enclosed = in usage
    else:
        pass
        # cant enclose, lens not put on


def LreopenAperture():
    if oAperture.getState():
        oAperture.setState(0)
    else:
        pass
        # already opened = ready to use

