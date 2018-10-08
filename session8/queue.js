function Queue() {
    this.front = 0;
    this.rear = 0;
    this.array = {};
}

Queue.prototype.enqueue = function (data) {
    if (this.front == 0) {
        this.array[++this.rear] = data;
        this.front++;
    } else {
        this.array[++this.rear] = data;
    }
};

Queue.prototype.dequeue = function () {
    var oldestIndex = this.front,
        newestIndex = this.rear,
        deletedData;
    var size = size = this.rear;
    var i = 0;
    if (oldestIndex !== newestIndex) {
        deletedData = this.array[oldestIndex];
        while (size) {
            this.array[this.front + i] = this.array[oldestIndex + i + 1];
            size--;
            i++;
        }
        delete this.array[this.rear];
        this.rear--;
        return deletedData;
    }
}
