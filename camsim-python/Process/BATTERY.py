from Process.OBJECTS import oBattery


def putIN():
    oBattery.setState(1)
def pullOUT():
    #power off option for furhter dev
    oBattery.setState(0)
def change() -> bool:
    if oBattery.getState():
        #power off option for further dev
        oBattery.setState(0)
        oBattery.setPercentage(1.00)
        oBattery.setState(1)
        return True
    else:
        return False



