class Shutter:
    fastest: float
    longest: float
    speed: float  # in seconds
    enclosure: int # 0 CLOSED 1 OPEN
    state: int  # 0 available 1 busy

    def __init__(self, defaultSS):
        self.fastest = 1 / 8000
        self.longest = 10.0
        self.speed = defaultSS
        self.state = 0
        self.enclosure = 0

    def getFastestSpeed(self):
        return self.fastest

    def getLongestSpeed(self):
        return self.longest

    def getCurrentSS(self):
        return self.speed

    def setSpeed(self, newSS):
        if newSS != self.speed:
            self.speed = newSS
            return True
        else:
            return False

    def getState(self):
        return self.state

    # def setState(self, newState):
    #     self.state = newState
    def setState(self, newState) -> bool:
        if newState != self.state:
            self.state = newState
            return True
        else:
            return False

    def getEnclosureState(self):
        return self.enclosure

    def setEnclosureState(self, newState) -> bool:
        if newState != self.enclosure:
            self.enclosure = newState
            return True
        else:
            return False
