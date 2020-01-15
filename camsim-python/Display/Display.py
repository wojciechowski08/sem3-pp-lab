class Display:
    brightness: int # min 1 max 10
    state: int  # 0 OFF 1 ON

    def __init__(self):
        self.brightness = 10
        self.state = 0

    def getState(self) -> int:
        return self.state

    def setState(self, newState) -> bool:
        if self.state != newState:
            self.state = newState
            return True
        else:
            return False

    def getBrightness(self) -> int:
        return self.brightness

    def setBrightness(self, newBrightness) -> bool:
        if 1 <= newBrightness <= 10:
            self.brightness = newBrightness
            return True
        else:
            return False
            # cant go dimmer or brighter than 1 or 10
