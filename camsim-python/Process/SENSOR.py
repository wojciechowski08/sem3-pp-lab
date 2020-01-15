import time

from Process.OBJECTS import oSensor


def SturnON():
    oSensor.setState(0)


def SturnOFF():
    oSensor.setState(-1)
    # finish on-going processes


def SgoIntoLiveView():
    if oSensor.getState() == 0:
        if oSensor.getAction() != "lv":
            oSensor.setAction("lv")
        else:
            pass
            # cant switch sensor into live view mode
    elif oSensor.getState() == 1:
        pass
        # sensor is occupied
    else:
        pass
        # sensor is switched off


def ScapturePhoto() -> str:
    if oSensor.getState() == 0:
        oSensor.setState(1)
        oSensor.setAction("capturing")
        data: str = oSensor.readLight()
        oSensor.setAction("lv")
        oSensor.setState(0)
        return data
    elif oSensor.getState() == 1:
        pass
        # the sensor is already capturing a photograph
    else:
        pass
        # sensor is switched off


def ScleanSensor():
    if oSensor.getState() == 0:
        oSensor.setState(1)
        oSensor.setAction("cleaning")
        # prompt about cleaning
        time.sleep(2)
        oSensor.getAction("lv")
        oSensor.setState(0)
    elif oSensor.getState() == 1:
        pass
        # sensor is occupied
    else:
        pass
        # sensor is switched off
