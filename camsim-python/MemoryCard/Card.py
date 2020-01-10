from typing import List

from File.File import File
from File.Photo import Photo


class Card:
    capacity: int  # int of MB
    writeSpeed: int  # int of MB/s
    readSpeed: int  # int of MB/s
    state: int  # 0 OUT 1 IN
    inUsage: int  # 0 not used 1 IN USAGE
    usedSpace: int  # FULL
    roll: List[Photo]  # photo roll
    otherSpace: List[File]  # space for other files

    def __init__(self, capacity, write, read):
        self.capacity = capacity * 1024  # in GB to MB
        self.writeSpeed = write
        self.readSpeed = read
        self.state = 0

        self.inUsage = 0
        self.usedSpace = 0
        self.roll = []
        self.otherSpace = []

    def getCapacity(self):
        return self.capacity

    def getWriteSpeed(self):
        return self.writeSpeed

    def getReadSpeed(self):
        return self.readSpeed

    def getState(self):
        return self.state

    def getUsageState(self):
        return self.inUsage

    def getUsedSpace(self):
        return self.usedSpace

    def getAvailableSpace(self):
        return self.capacity - self.usedSpace

    def setState(self, newState) -> bool:
        if newState != self.state:
            self.state = newState
            return True
        else:
            return False

    def setInUsageState(self, newState) -> bool:
        if newState != self.inUsage:
            self.inUsage = newState
            return True
        else:
            return False

    def write(self, file: File) -> bool:
        if self.capacity - self.usedSpace >= file.size:
            if type(file) == Photo:
                # self.roll.append(file)
                self.roll.insert(0, file)
            else:
                # self.otherSpace.append(file)
                self.otherSpace.insert(0, file)
            self.usedSpace += file.size
            return True
        else:
            return False

    def read(self, fileType: str, index: int) -> File:
        if self.usedSpace != 0:
            if fileType == "Photo":
                if 0 <= index <= len(self.roll):
                    return self.roll[index]
                else:
                    pass
                    # info about index failure
            elif fileType == "File":
                if 0 <= index <= len(self.otherSpace):
                    return self.otherSpace[index]
                else:
                    pass
                    # info about index failure
        else:
            pass
            # info about no files saved

    def delete(self, fileType: str, index: int) -> bool:
        if fileType == "Photo":
            if 0 <= index <= len(self.roll):
                del self.roll[index]
            else:
                return False
        else:
            if 0 <= index <= len(self.otherSpace):
                del self.otherSpace[index]
            else:
                return False
        return True
