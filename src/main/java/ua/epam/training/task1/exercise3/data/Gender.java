package ua.epam.training.task1.exercise3.data;

public enum Gender {
    Male {
        @Override
        public String toString() {
            return "Мужской";
        }
    },
    Female {
        @Override
        public String toString() {
            return "Женский";
        }
    }
}
