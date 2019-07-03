package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static ExpenseService.Expense.ExpenseType.EXPENSE_TYPE_A;
import static ExpenseService.Expense.ExpenseType.EXPENSE_TYPE_B;
import static ExpenseService.Expense.ExpenseType.INTERNAL_PROJECT_EXPENSE;
import static ExpenseService.Expense.ExpenseType.OTHER_EXPENSE;
import static ExpenseService.Project.ProjectType.EXTERNAL;
import static ExpenseService.Project.ProjectType.INTERNAL;
import static ExpenseService.Project.ProjectType.UNEXPECTED_PROJECT_TYPE;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(INTERNAL, "Pj");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        Assertions.assertEquals(INTERNAL_PROJECT_EXPENSE, expenseType);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL, "Project A");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        Assertions.assertEquals(EXPENSE_TYPE_A, expenseType);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL, "Project B");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        Assertions.assertEquals(EXPENSE_TYPE_B, expenseType);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(EXTERNAL, "Other Project");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        Assertions.assertEquals(OTHER_EXPENSE, expenseType);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        // given
        Project project = new Project(UNEXPECTED_PROJECT_TYPE, "Other Project");
        // when
        // then
        assertThrows(UnexpectedProjectTypeException.class,
                () -> ExpenseService.getExpenseCodeByProjectTypeAndName(project),
                "You enter invalid project type");
    }
}