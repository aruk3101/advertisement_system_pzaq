import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import useForm from "hooks/useForm";
import Form from "components/common/Form/Form";
import Input from "components/common/Input/Input";
import Submit from "components/common/Submit/Submit";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import Select from "components/common/Select/Select";
import useCompanies from "hooks/useCompanies";
import useAdvertisementCategories from "hooks/useAdvertisementCategories";
import useContractTypes from "hooks/useContractTypes";
import usePositionLevels from "hooks/usePositionLevels";
import useWorkingTimeTypes from "hooks/useWorkingTimeTypes";
import useJobTypes from "hooks/useJobTypes";
import useAddEditAdvertisement from "hooks/useAddEditAdvertisement";

export default function EditAdvertisementForm({
  forceClose,
  element,
  refreshMethod = null,
}) {
  const { handleSubmit, Alerts, isLoading } = useAddEditAdvertisement();
  var { items } = useCompanies(0, 100000);
  var { advertisementCategories } = useAdvertisementCategories();
  var { contractTypes } = useContractTypes();
  var { positionLevels } = usePositionLevels();
  var { workingTimeTypes } = useWorkingTimeTypes();
  var { jobTypes } = useJobTypes();
  var dto = {
    companyUuid: "",
    advertisementCategoryUuid: "",
    position: "",
    positionLevelUuid: "",
    contractTypeUuid: "",
    workingTimeTypeUuid: "",
    jobTypeUuid: "",
    salaryFrom: 0,
    salaryTo: 0,
    workingDays: "",
    workingHours: "",
    expirationDate: "",
    version: 0,
  };
  if (element != null) {
    dto.companyUuid = element.companyUuid;
    dto.advertisementCategoryUuid = element.advertisementCategoryUuid;
    dto.position = element.position;
    dto.positionLevelUuid = element.positionLevelUuid;
    dto.contractTypeUuid = element.contractTypeUuid;
    dto.workingTimeTypeUuid = element.workingTimeTypeUuid;
    dto.jobTypeUuid = element.jobTypeUuid;
    dto.salaryFrom = element.salaryFrom;
    dto.salaryTo = element.salaryTo;
    dto.workingDays = element.workingDays;
    dto.workingHours = element.workingHours;
    dto.expirationDate = element.expirationDate;
    dto.version = element.version;
  }
  const { data, handleChange } = useForm(dto);

  return (
    <div className="container-md">
      <SpinnerView isLoading={isLoading}>
        <div className="row">
          <EmptyGridSpace xs="0" md="1" />
          <Form
            className="col"
            method="post"
            onSubmit={(event) => {
              if (
                data.advertisementCategoryUuid == "" ||
                data.advertisementCategoryUuid == null
              )
                data.advertisementCategoryUuid =
                  advertisementCategories[0].uuid;
              if (
                data.positionLevelUuid == "" ||
                data.positionLevelUuid == null
              )
                data.positionLevelUuid = positionLevels[0].uuid;
              if (data.contractTypeUuid == "" || data.contractTypeUuid == null)
                data.contractTypeUuid = contractTypes[0].uuid;
              if (
                data.workingTimeTypeUuid == "" ||
                data.workingTimeTypeUuid == null
              )
                data.workingTimeTypeUuid = workingTimeTypes[0].uuid;
              if (data.jobTypeUuid == "" || data.jobTypeUuid == null)
                data.jobTypeUuid = jobTypes[0].uuid;
              if (data.companyUuid == "" || data.companyUuid == null)
                data.companyUuid = items[0].uuid;

              const convertToISO = (dateString) => {
                const date = new Date(dateString);
                return date.toISOString();
              };
              data.expirationDate = convertToISO(data.expirationDate);
              data.version = data.version + 1;
              handleSubmit(event, data, forceClose, element, refreshMethod);
            }}
          >
            <Input
              placeholder="Stanowisko"
              name="position"
              type="text"
              id="position"
              value={data["position"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Pensja od"
              name="salaryFrom"
              type="number"
              id="salaryFrom"
              value={data["salaryFrom"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Pensja od"
              name="salaryTo"
              type="number"
              id="salaryTo"
              value={data["salaryTo"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Dni pracy"
              name="workingDays"
              type="text"
              id="workingDays"
              value={data["workingDays"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Godziny Pracy"
              name="workingHours"
              type="text"
              id="workingHours"
              value={data["workingHours"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Data wygaśnięcia"
              name="expirationDate"
              type="date"
              id="expirationDate"
              value={data["expirationDate"]}
              handleChange={handleChange}
              required="required"
            />
            <Select
              placeholder="Przedsiębiorstwo"
              name="companyUuid"
              id="companyUuid"
              value={data["companyUuid"]}
              handleChange={handleChange}
              required="required"
              options={items.map((value) => {
                return {
                  value: value.uuid,
                  name: value.name,
                };
              })}
            ></Select>
            <Select
              placeholder="Kategoria"
              name="advertisementCategoryUuid"
              id="advertisementCategoryUuid"
              value={data["advertisementCategoryUuid"]}
              handleChange={handleChange}
              required="required"
              options={advertisementCategories.map((value) => {
                return {
                  value: value.uuid,
                  name: value.name,
                };
              })}
            ></Select>
            <Select
              placeholder="Typ umowy"
              name="contractTypeUuid"
              id="contractTypeUuid"
              value={data["contractTypeUuid"]}
              handleChange={handleChange}
              required="required"
              options={contractTypes.map((value) => {
                return {
                  value: value.uuid,
                  name: value.name,
                };
              })}
            ></Select>
            <Select
              placeholder="Typ pracy"
              name="jobTypeUuid"
              id="jobTypeUuid"
              value={data["jobTypeUuid"]}
              handleChange={handleChange}
              required="required"
              options={jobTypes.map((value) => {
                return {
                  value: value.uuid,
                  name: value.name,
                };
              })}
            ></Select>
            <Select
              placeholder="Typ wymiaru czasu pracy"
              name="workingTimeTypeUuid"
              id="workingTimeTypeUuid"
              value={data["workingTimeTypeUuid"]}
              handleChange={handleChange}
              required="required"
              options={workingTimeTypes.map((value) => {
                return {
                  value: value.uuid,
                  name: value.name,
                };
              })}
            ></Select>
            <Select
              placeholder="Poziom stanowiska"
              name="positionLevelUuid"
              id="positionLevelUuid"
              value={data["positionLevelUuid"]}
              handleChange={handleChange}
              required="required"
              options={positionLevels.map((value) => {
                return {
                  value: value.uuid,
                  name: value.name,
                };
              })}
            ></Select>
            <Submit value="Prześlij" />
            <Alerts />
          </Form>
          <EmptyGridSpace xs="0" md="1" />
        </div>
      </SpinnerView>
    </div>
  );
}
