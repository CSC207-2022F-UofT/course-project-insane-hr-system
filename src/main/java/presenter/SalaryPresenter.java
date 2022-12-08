package presenter;

import use_case.salary_calculator.SalaryCalculatorOutputBoundary;
import use_case.salary_calculator.SalaryResponseModel;

public class SalaryPresenter implements SalaryCalculatorOutputBoundary {
    private final SalaryIView view;

    public SalaryPresenter(SalaryIView view) {
        this.view = view;
    }

    @Override
    public SalaryResponseModel prepareSucceedPage(SalaryResponseModel salaryResponseModel) {
//        Field[] fields = PayStub.class.getFields();
//
//        List<PayStub> payStubs = salaryResponseModel.getPayStubs();
//        int numOfPayStubs = payStubs.size();
//        Object[][] objects = new Object[numOfPayStubs + 1][fields.length];
//        for(int i = 0; i < fields.length; i ++) {
//            objects[0][i] = fields[i].getName();
//        }
//        for (int i = 1; i < numOfPayStubs + 1; i++) {
//            for(int j = 0; j < fields.length; j ++) {
//                Field field = fields[j];
//                field.setAccessible(true);
//                try {
//                    objects[i][j] = field.get(payStubs.get(i));
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//                if (objects[i][j] instanceof LocalDate) {
//                    objects[i][j] = ((LocalDate) objects[i][j]).toString();
//                }
//            }
//            }
//        return objects;
            view.succeedPage(DataFormatter.tableFormatter(salaryResponseModel));

            return salaryResponseModel;
        }

    @Override
    public SalaryResponseModel prepareFailedPage(String error) {

        return null;
    }
}
