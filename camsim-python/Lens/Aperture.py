from typing import List

from Lens.Lens import Lens


# from Process.OBJECTS import oLens


class Aperture:
    currentSetting: float  # current F stop
    state: int  # 0 for fully open 1 for enclosed occupied
    lens: Lens
    apertures: List[float]

    def __init__(self, lens: Lens):
        self.state = 0
        self.lens = lens
        self.currentSetting = self.lens.getMaxAperture()
        self.apertures = [2.0, 2.8, 4.0, 5.6, 8.0, 11.0, 16.0, 22.0, 32.0]

    def getCurrentAperture(self):
        return self.currentSetting

    def setCurrentAperture(self, aperture) -> bool:
        if self.lens.getState():
            if self.lens.getMaxAperture() <= aperture <= self.lens.getMinAperture():
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

    def getApertureTable(self):
        return self.apertures

