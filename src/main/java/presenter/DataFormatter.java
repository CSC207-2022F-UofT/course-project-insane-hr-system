package presenter;

import salary_calculator.PayStub;
import salary_calculator.SalaryResponseModel;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;

public class DataFormatter {

    public static Object[][] tableFormatter(SalaryResponseModel salaryResponseModel) {
        Field[] fields = PayStub.class.getDeclaredFields();
        List<PayStub> payStubs = salaryResponseModel.getPayStubs();

        int numOfPayStubs = payStubs.size();
        int columnNumber = fields.length;
        Object[][] objects = new Object[numOfPayStubs + 1][fields.length];
        for(int i = 0; i < fields.length; i ++) {
            objects[0][i] = fields[i].getName();
        }
        for (int i = 0; i < numOfPayStubs; i++) {
            for(int j = 0; j < fields.length; j ++) {
                Field field = fields[j];
                field.setAccessible(true);
                System.out.println(field.getName());
                try {
                    objects[i+1][j] = field.get(payStubs.get(i));
                    System.out.println(field.get(payStubs.get((i))));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (objects[i][j] instanceof LocalDate) {
                    objects[i][j] = ((LocalDate) objects[i][j]).toString();
                }
            }
        }
        return objects;
    }
}
