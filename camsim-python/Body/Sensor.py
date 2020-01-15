import random
import string


class Sensor:
    maxISO: int
    minISO: int
    state: int  # off -1 ready 0 occupied 1
    action: str  #  lv - live view, capturing picture, cleaning
    ISO: int

    def __init__(self, maxISO, minISO):
        self.maxISO = maxISO
        self.minISO = minISO
        self.state = 0
        self.action = "standby"
        self.ISO = 100

    def getMinISO(self) -> int:
        return self.minISO

    def getMaxISO(self) -> int:
        return self.maxISO

    def getState(self) -> int:
        return self.state

    def setState(self, newState) -> bool:
        if newState != self.state:
            self.state = newState
            return True
        else:
            return False

    def getAction(self) -> str:
        return self.action

    def setAction(self, newAction) -> bool:
        if newAction != self.action:
            if newAction == "lv":
                self.action = newAction
            elif newAction == "capturing":
                self.action = newAction
            elif newAction == "cleaning":
                self.action = newAction
        else:
            return False

    def readLight(self) -> str:
        return ''.join(random.choices(string.ascii_uppercase + string.digits, k=10))

    def getISO(self) -> int:
        return self.ISO

    def setISO(self, newISO) -> bool:
        self.ISO = newISO
        return True