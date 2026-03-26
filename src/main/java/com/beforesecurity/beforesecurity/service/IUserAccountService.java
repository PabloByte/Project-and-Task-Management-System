package com.beforesecurity.beforesecurity.service;

import java.util.List;

import com.beforesecurity.beforesecurity.dto.UserAccountDtoInsert;
import com.beforesecurity.beforesecurity.dto.UserAccountDtoReturn;
import com.beforesecurity.beforesecurity.model.UserAccount;

public interface IUserAccountService {



        List<UserAccountDtoReturn> showAccounts();

        UserAccountDtoReturn saveAdministrator (UserAccountDtoInsert userInf);
        UserAccountDtoReturn register (UserAccountDtoInsert userInf);

        




}
