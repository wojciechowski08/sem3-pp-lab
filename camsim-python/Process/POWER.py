from Process.OBJECTS import oBattery, oBody, oSensor, oShutter, oDisplay, oAperture, oLens, oCard


def TURNON() -> bool:
    if oBattery.getState():
        if not oBody.getState():
            oBody.setState(1)
            oSensor.setState(0)
            oSensor.setAction('lv')
            oShutter.setState(0)
            oShutter.setEnclosureState(1)
            oDisplay.setState(1)
            if oLens.getState():
                oAperture.setState(0)
            return True
        else:
            return False
            # camera already turned on
    else:
        return False


def TURNOFF() -> bool:
    if oBattery.getState():
        if oBody.getState():
            if oCard.getState():
                if oCard.getUsageState():
                    return False
                    #card still in usage
            if oSensor.getState():
                return False
                # sensor still in usage
            if oShutter.getState():
                return False
                # shutter still in usage
            if oLens.getState():
                if oAperture.getState():
                    return False
                    # aperture still enclosed in usage

            oDisplay.setState(0)
            oShutter.setEnclosureState(0)
            oShutter.setState(0) # shutter is not busy when cam is off
            oSensor.setAction('lv')
            oSensor.setState(-1)
            if oLens.getState():
                oAperture.setState(0)
            if oCard.getState():
                oCard.setInUsageState(0)
            oBody.setMode('lv')
            oBody.setState(0)
            return True

        else:
            return False
            # camera not turned on
    else:
        return False
        # battery not in so cant do any action
