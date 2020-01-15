from Process.OBJECTS import oBattery


def BputIN():
    oBattery.setState(1)


def BpullOUT():
    # power off option for further dev
    oBattery.setState(0)


def Bchange() -> bool:
    if oBattery.getState():
        # power off option for further dev
        oBattery.setState(0)
        oBattery.setPercentage(1.00)
        oBattery.setState(1)
        return True
    else:
        return False
