class Battery:
    percentage:float # from 0 to 1
    state:int # 0 or 1

    def __init__(self):
        self.percentage = 1
        self.state = 0
    def getPercentage(self):
        return self.percentage
    def getState(self):
        return self.state
    def setState(self, newState) -> bool:
        if newState != self.state:
            self.state = newState
            return True
        else:
            return False
    def setPercentage(self, p) -> bool:
        self.percentage = p
        return True