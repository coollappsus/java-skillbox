public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] temperatureData = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            temperatureData[i] = Math.round(32 + (float) (Math.random() * 8));
        }
        //TODO: напишите метод генерации массива температур пациентов

        return temperatureData;
    }

    public static String getReport(float[] temperatureData) {
        String patientsTemperatures = "";
        float averageTemperatures = 0;
        float sum = 0;
        int countHealthyPeople = 0;
        int length = temperatureData.length;

        for (int i = 0; i < length; i++) {
            patientsTemperatures += temperatureData[i] + " ";
            sum += temperatureData[i];
            if (temperatureData[i] > 36.1 && temperatureData[i] < 37) {
                countHealthyPeople++;
            }
        }
        patientsTemperatures = patientsTemperatures.substring(0, patientsTemperatures.length() - 1);
        averageTemperatures = sum / length;
        averageTemperatures = averageTemperatures * 100;
        int result = (int) Math.round(averageTemperatures);
        averageTemperatures = (float) result / 100;

        String report =
                "Температуры пациентов: " + patientsTemperatures +
                        "\nСредняя температура: " + averageTemperatures +
                        "\nКоличество здоровых: " + countHealthyPeople;

        return report;
    }
}
