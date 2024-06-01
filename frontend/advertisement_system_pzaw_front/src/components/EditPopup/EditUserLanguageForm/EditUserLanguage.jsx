import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import useForm from "hooks/useForm";
import Form from "components/common/Form/Form";
import Input from "components/common/Input/Input";
import Submit from "components/common/Submit/Submit";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import Select from "components/common/Select/Select";
import useAddEditUserLanguage from "hooks/useAddEditUserLanguage";
import useLanguageLevels from "hooks/useLanguageLevels";

export default function EditUserLanguageForm({ forceClose, element }) {
  const { handleSubmit, Alerts, isLoading } = useAddEditUserLanguage();
  const { languageLevels } = useLanguageLevels();
  var dto = {
    language: "",
    languageLevelUuid: "",
    version: 0,
  };
  if (element != null) {
    dto = element;
    dto.languageLevelUuid = element.languageLevel.uuid;
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
                data.languageLevelUuid == null ||
                data.languageLevelUuid == ""
              )
                data.languageLevelUuid = languageLevels[0];
              if (
                data.languageLevelUuid != null &&
                typeof data.languageLevelUuid === "object"
              )
                data.languageLevelUuid = data.languageLevelUuid.uuid;
              handleSubmit(event, data, forceClose, element);
            }}
          >
            <Input
              placeholder="Język"
              name="language"
              type="text"
              id="language"
              value={data["language"]}
              handleChange={handleChange}
              required="required"
            />
            <Select
              placeholder="Poziom"
              name="languageLevelUuid"
              id="languageLevelUuid"
              value={data["languageLevelUuid"]}
              handleChange={handleChange}
              required="required"
              options={languageLevels.map((ll) => {
                return {
                  value: ll.uuid,
                  name: ll.name,
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
