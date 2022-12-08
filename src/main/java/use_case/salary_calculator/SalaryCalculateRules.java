package use_case.salary_calculator;

import entity.task.CommonTask;
import entity.task.Task;
import entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class SalaryCalculateRules implements SalaryCalculator{
    public Integer salaryPerTask = 10;
    public Integer salaryPerHour = 20;
    public Integer salaryPerStar = 1;
    public Integer resetDate = 5;

    public SalaryCalculateRules() {
    }

    public SalaryCalculateRules(Integer salaryPerTask, Integer salaryPerHour, Integer salaryPerStar, Integer resetDate) {
        this.salaryPerTask = salaryPerTask;
        this.salaryPerHour = salaryPerHour;
        this.salaryPerStar = salaryPerStar;
        this.resetDate = resetDate;
    }

    @Override
    public Integer getBonusSalary(User user) {

        List<CommonTask> commonTasks = new ArrayList<>();

        for (Task task : user.getTasks()) {
            if (task instanceof CommonTask && ((CommonTask) task).getStar() != null) {
                commonTasks.add(((CommonTask) task));
            }
        }

        int result = 0;
        for (CommonTask commonTask : commonTasks) {
            result = result + this.salaryPerTask + commonTask.getStar() * this.salaryPerStar;
        }
        return result;
    }

    @Override
    public Integer getHourSalary(User user) {
        // TODO: this is not the highest position.
        Integer salaryPerHour = SalaryPositionMap.getHourSalaryByPosition(user.getRoles().get(0));

        return salaryPerHour;
    }

    @Override
    public Integer getTotalSalary(User user) {
        return null;
    }

    @Override
    public Integer getBalance(User user) {
        return null;
    }

    @Override
    public Integer getResetDate() {
        return this.resetDate;
    }
}
