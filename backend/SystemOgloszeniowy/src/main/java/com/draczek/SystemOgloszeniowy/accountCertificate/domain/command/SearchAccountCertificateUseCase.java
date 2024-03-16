package com.draczek.SystemOgloszeniowy.accountCertificate.domain.command;

import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.AccountCertificateDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

/**
 * Class for searching Account certificates.
 */
@RequiredArgsConstructor
public class SearchAccountCertificateUseCase {
  private final AccountCertificateMapper accountCertificateMapper;
  private final AccountCertificateRepository accountCertificateRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for searching user's account certificates.
   *
   * @return list of AccountCertificateDto
   */
  public List<AccountCertificateDto> search() {
    return accountCertificateRepository.findAll(specificationForLoggedInAccount()).stream()
        .map(accountCertificateMapper::toDto).toList();
  }

  public AccountCertificateDto search(UUID uuid) {
    return accountCertificateMapper.toDto(accountCertificateRepository
        .get(uuid, securityFacade.getLoggedInAccount()));
  }

  private Specification<AccountCertificate> specificationForLoggedInAccount() {
    return (root, query, cb) -> cb.and(
        cb.equal(root.get(AccountCertificate_.ACCOUNT),
            securityFacade.getLoggedInUser().getUserDetails().getAccount())
    );
  }
}

