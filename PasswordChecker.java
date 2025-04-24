public class PasswordChecker {

    int minLength;
    int maxRepeats;

    public void setMinLength(int minLength) {
        this.minLength = minLength;
        if (this.minLength <= 0) {
            throw new IllegalArgumentException("Недопустимая длина пароля!");
        }
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        this.maxRepeats = maxRepeats;
        if (this.maxRepeats <= 0 || this.maxRepeats == 0) {
            throw new IllegalArgumentException("Недопустимое количество повторений!");
        }
    }

    public boolean verify(String password) {
        if (this.minLength <= 0 || this.maxRepeats <= 0 || this.maxRepeats == 0) {
            throw new IllegalStateException("Одна из двух настроек не была выставлена чекеру");
        }

        if (repeatsCounter(password) >= this.maxRepeats) {
            return false;
        } else if (this.minLength >= password.length()) {
            return false;
        } else {
            return true;
        }
    }

    public int repeatsCounter(String password){
        int count = 1;

        for (int i = 0; i < password.length(); i++) {
            boolean match = true;

            for (int j = i + 1; j < password.length(); j++) {
                if (password.charAt(i) != password.charAt(j)) {

                    match = false;
                    break;
                }
            }

            if (match) {
                count++;
            }

        }
        return count;
    }
}

