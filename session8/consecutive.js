function removeConsecutiveCharacter(inputString) {
    for (var i = 0; i < inputString.length - 2; i++) {
        var count = i;
        var stringToBeReplaced = inputString.charAt(i);
        while (inputString.charAt(count) == inputString.charAt(count + 1)) {
            stringToBeReplaced += inputString.charAt(count);
            count++;
        }
        if (count > i) {
            inputString = inputString.replace(stringToBeReplaced, "");
            if (i == 0) {
                i--;
            } else {
                i = i - 2;
            }

        }
    }
    return inputString;
}
