class Button:
    name: str
    state: int  # 0 not; 1 pressed

    def __init__(self, name: str):
        self.name = name
        self.state = 0

    def __str__(self):
        return self.name

    def getName(self):
        return self.name

    def getState(self):
        return self.state

    def reset(self):
        self.state = 0

    def press(self):
        self.state = 1

    def hold(self) -> bool:
        if self.state:
            return False
            # already pressed
        else:
            self.state = 1
            return True

    def unpress(self):
        if self.state:
            self.state = 0
            return True
        else:
            return False
            # button not pressed
