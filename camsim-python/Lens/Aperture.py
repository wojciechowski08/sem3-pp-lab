from Process.OBJECTS import oLens


class Aperture:
    currentSetting: float  # current F stop
    state: int  # 0 for fully open 1 for enclosed occupied

    def __init__(self):
        self.currentSetting = oLens.getMaxAperture()
        self.state = 0

    def getCurrentAperture(self):
        return self.currentSetting

    def setCurrentAperture(self, aperture) -> bool:
        if oLens.getState():
            if oLens.getMaxAperture() <= aperture <= oLens.getMinAperture():
                self.currentSetting = aperture
                return True
        return False

    def getState(self):
        return self.state

    def setState(self, newState) -> bool:
        if newState != self.state:
            self.state = newState
            return True
        else:
            return False