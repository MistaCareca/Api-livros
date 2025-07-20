package mapper;

import dto.LoanDTO;
import model.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface LoanMapper {
    LoanDTO toDto(Loan loan);
    Loan toEntity(LoanDTO loanDTO);
}
