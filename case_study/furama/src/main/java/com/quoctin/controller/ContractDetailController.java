package com.quoctin.controller;

import com.quoctin.dto.ContractDetailDto;
import com.quoctin.dto.ContractDto;
import com.quoctin.model.contract.AttachService;
import com.quoctin.model.contract.Contract;
import com.quoctin.model.contract.ContractDetail;
import com.quoctin.service.icontract.IAttachServiceService;
import com.quoctin.service.icontract.IContractDetailService;
import com.quoctin.service.icontract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping({"/detail"})
public class ContractDetailController {

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IAttachServiceService iAttachServiceService;

    @ModelAttribute("contract")
    public List<Contract> contractList() {
        return iContractService.findAllContract();
    }

    @ModelAttribute("attach")
    public List<AttachService> attachServiceList() {
        return iAttachServiceService.findAll();
    }


    @GetMapping(value = "/list")
    public String contractDetailList(@PageableDefault(value = 2) Pageable pageable,
                                 Model model) {
        Page<ContractDetail> contractDetailPage = this.iContractDetailService.findAll(pageable);
        model.addAttribute("contractDetail", contractDetailPage);
        return "contract/contract_detail_list";
    }

    @GetMapping("/create")
    public String showCreateContractDetail(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "contract/contract_detail_create";
    }

    @PostMapping("/create")
    public String createContract(@ModelAttribute @Validated ContractDetailDto contractDetailDto, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "contract/contract_detail_create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            iContractDetailService.save(contractDetail);
            return "redirect:/detail/list";
        }
    }
}
