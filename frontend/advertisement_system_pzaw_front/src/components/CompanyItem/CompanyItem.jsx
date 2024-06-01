import "./CompanyItem.css";

export default function CompanyItem({ company }) {
  return (
    <div className="contrainer-flex">
      <div className="row">
        <div className="col-12">
          <h3>{company.name}</h3>
          <p>
            <span>
              {company.address.city}&nbsp;
              {company.address.postalCode} &nbsp;
              {company.address.postalName} |{company.address.country}
            </span>
          </p>
        </div>
      </div>
    </div>
  );
}
