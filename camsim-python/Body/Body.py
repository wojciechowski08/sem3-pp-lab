import random


class Body:
    state: int  # 0 off 1 on
    orientation: int  # 0 horizontal 1 vertical
    mode: str  # lv, menu, info, gallery
    facingLight: float

    def __init__(self):
        self.state = 0
        self.orientation = 0
        self.mode = 'lv'
        self.facingLight = random.uniform(-15.0, 20.0)

    def getState(self) -> int:
        return self.state

    def setState(self, newState: int) -> bool:
        if self.state != newState:
            self.state = newState
            return True
        else:
            return False

    def getOrientation(self) -> int:
        return self.orientation

    def setOrientation(self, newOrientation) -> bool:
        if self.orientation != newOrientation:
            self.orientation = newOrientation
            return True
        else:
            return False

    def getMode(self) -> str:
        return self.mode

    def setMode(self, newMode) -> bool:
        if self.mode != newMode:
            self.mode = newMode
            return True
        else:
            self.mode = 'lv'
            return True     # ?

    def getFacingLight(self) -> float:
        return self.facingLight

    def move(self) -> float:
        ev = random.uniform(-15.0, 20.0)
        self.facingLight
        return ev
