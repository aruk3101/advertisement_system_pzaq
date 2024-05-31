import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import useForm from "hooks/useForm";
import Form from "components/common/Form/Form";
import Input from "components/common/Input/Input";
import Submit from "components/common/Submit/Submit";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import useAddEditCompany from "hooks/useAddEditCompany";

export default function EditCompanyForm({
  forceClose,
  element,
  refreshMethod = null,
}) {
  const { handleSubmit, Alerts, isLoading } = useAddEditCompany(); //TODO zmienic
  var dto = {
    name: "",
    iframeHyperlink: "",
    description: "",
    version: 0,
    city: "",
    postalName: "",
    postalCode: "",
    street: "",
    streetNumber: "",
    apartmentNumber: "",
    country: "",
    addressVersion: 0,
  };
  if (element != null) {
    dto.name = element.name;
    dto.description = element.description;
    dto.iframeHyperlink = element.iframeHyperlink;
    dto.version = element.version;
    dto.city = element.address.city;
    dto.postalName = element.address.postalName;
    dto.postalCode = element.address.postalCode;
    dto.street = element.address.street;
    dto.streetNumber = element.address.streetNumber;
    dto.apartmentNumber = element.address.apartmentNumber;
    dto.country = element.address.country;
    dto.addressVersion = element.address.version;
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
              handleSubmit(event, data, forceClose, element, refreshMethod);
            }}
          >
            <Input
              placeholder="Nazwa"
              name="name"
              type="text"
              id="name"
              value={data["name"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Link do mapy"
              name="iframeHyperlink"
              type="text"
              id="iframeHyperlink"
              value={data["iframeHyperlink"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Opis"
              name="description"
              type="text"
              id="description"
              value={data["description"]}
              handleChange={handleChange}
              required="required"
            />
            {element != null ? (
              <>
                <Input
                  placeholder="Miejscowość"
                  name="city"
                  type="text"
                  id="city"
                  value={data["city"]}
                  handleChange={handleChange}
                  required="required"
                />
                <Input
                  placeholder="Miasto"
                  name="postalName"
                  type="text"
                  id="postalName"
                  value={data["postalName"]}
                  handleChange={handleChange}
                  required="required"
                />
                <Input
                  placeholder="Kod pocztowy"
                  name="postalCode"
                  type="text"
                  id="postalCode"
                  value={data["postalCode"]}
                  handleChange={handleChange}
                  required="required"
                />
                <Input
                  placeholder="Ulica"
                  name="street"
                  type="text"
                  id="street"
                  value={data["street"]}
                  handleChange={handleChange}
                  required="required"
                />
                <Input
                  placeholder="Numer domu"
                  name="streetNumber"
                  type="text"
                  id="streetNumber"
                  value={data["streetNumber"]}
                  handleChange={handleChange}
                  required="required"
                />
                <Input
                  placeholder="lokal"
                  name="apartmentNumber"
                  type="text"
                  id="apartmentNumber"
                  value={data["apartmentNumber"]}
                  handleChange={handleChange}
                  required="required"
                />
                <Input
                  placeholder="Państwo"
                  name="country"
                  type="text"
                  id="country"
                  value={data["country"]}
                  handleChange={handleChange}
                  required="required"
                />
              </>
            ) : (
              ""
            )}
            <Submit value="Prześlij" />
            <Alerts />
          </Form>
          <EmptyGridSpace xs="0" md="1" />
        </div>
      </SpinnerView>
    </div>
  );
}
