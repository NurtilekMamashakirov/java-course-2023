package edu.hw4;

import edu.hw4.Errors.AgeError;
import edu.hw4.Errors.HeightError;
import edu.hw4.Errors.NameError;
import edu.hw4.Errors.WeightError;

public class ValidationError {

    private NameError nameError;
    private AgeError ageError;
    private HeightError heightError;
    private WeightError weightError;

    public void checkAllErrors(Animal animal) {
        nameError = new NameError(animal);
        ageError = new AgeError(animal);
        heightError = new HeightError(animal);
        weightError = new WeightError(animal);
    }

    public NameError getNameError() {
        return nameError;
    }

    public AgeError getAgeError() {
        return ageError;
    }

    public HeightError getHeightError() {
        return heightError;
    }

    public WeightError getWeightError() {
        return weightError;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ValidationError that = (ValidationError) o;

        if (nameError != null ? !nameError.equals(that.nameError) : that.nameError != null) {
            return false;
        }
        if (ageError != null ? !ageError.equals(that.ageError) : that.ageError != null) {
            return false;
        }
        if (heightError != null ? !heightError.equals(that.heightError) : that.heightError != null) {
            return false;
        }
        return weightError != null ? weightError.equals(that.weightError) : that.weightError == null;
    }

    @Override
    public int hashCode() {
        int result = nameError != null ? nameError.hashCode() : 0;
        result = 31 * result + (ageError != null ? ageError.hashCode() : 0);
        result = 31 * result + (heightError != null ? heightError.hashCode() : 0);
        result = 31 * result + (weightError != null ? weightError.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return "ValidationError{"
            + "nameError=" + nameError
            + ", ageError=" + ageError
            + ", heightError=" + heightError
            + ", weightError=" + weightError
            + '}';
    }
}
