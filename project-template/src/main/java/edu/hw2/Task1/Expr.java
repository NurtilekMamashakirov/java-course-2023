package edu.hw2.Task1;

public interface Expr {
    double evaluate();

    public record Constant(Integer value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    public record Negate(Expr constant) implements Expr {
        @Override
        public double evaluate() {
            return -constant.evaluate();
        }
    }

    public record Exponent(Expr base, Integer power) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), power);
        }
    }

    public record Addition(Expr constant1, Expr constant2) implements Expr {
        @Override
        public double evaluate() {
            return constant1.evaluate() + constant2.evaluate();
        }
    }

    public record Multiplication(Expr constant1, Expr constant2) implements Expr {
        @Override
        public double evaluate() {
            return constant1.evaluate() * constant2.evaluate();
        }
    }
}
