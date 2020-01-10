class Lens:
    maxAperture: float
    minAperture: float
    focalLength: int  # in mm
    state: int  # 0 OFF 1 ON
    #focusing range
    #focusing state
    #autofocusing motors working state

    def __init__(self, f, maxAperture, minAperture):
        self.focalLength = f
        self.maxAperture = maxAperture
        self.minAperture = minAperture
        self.state = 0

    def getMaxAperture(self):
        return self.maxAperture

    def getMinAperture(self):
        return self.minAperture

    def getState(self):
        return self.state

    def setState(self, newState) -> bool:
        if newState != self.state:
            self.state = newState
            return True
        else:
            return False
