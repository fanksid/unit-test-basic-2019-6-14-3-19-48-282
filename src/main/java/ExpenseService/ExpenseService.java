package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import static ExpenseService.Expense.ExpenseType.EXPENSE_TYPE_A;
import static ExpenseService.Expense.ExpenseType.EXPENSE_TYPE_B;
import static ExpenseService.Expense.ExpenseType.INTERNAL_PROJECT_EXPENSE;
import static ExpenseService.Expense.ExpenseType.OTHER_EXPENSE;
import static ExpenseService.Project.ProjectType.EXTERNAL;
import static ExpenseService.Project.ProjectType.INTERNAL;

class ExpenseService {
    static ExpenseType getExpenseCodeByProjectTypeAndName(Project project) throws UnexpectedProjectTypeException {
        if (project.getProjectType() == INTERNAL) {
            return INTERNAL_PROJECT_EXPENSE;
        }

        if (project.getProjectType() == EXTERNAL) {
            if (project.getProjectName().equals("Project A")) {
                return EXPENSE_TYPE_A;
            }

            if (project.getProjectName().equals("Project B")) {
                return EXPENSE_TYPE_B;
            }

            return OTHER_EXPENSE;
        }

        throw new UnexpectedProjectTypeException("You enter invalid project type");
    }
}
