import "./AdvertisementItem.css";

export default function AdvertisementItem({ advertisement }) {
  return (
    <div className="contrainer-flex">
      <div className="row">
        <div className="col-12">
          <h3>{advertisement.position}</h3>
          <p>
            <span>{advertisement.company.name}</span>&nbsp;-&nbsp;
            <span>
              {advertisement.company.address.city}{" "}
              {advertisement.company.address.country}
            </span>
          </p>
          <p>
            <span>
              Pensja:&nbsp;
              {advertisement.salaryFrom}PLN&nbsp;-&nbsp;
              {advertisement.salaryTo}PLN
            </span>
          </p>
          <p>
            <span class="badge text-bg-secondary">
              {advertisement.advertisementCategory.name}
            </span>
            &nbsp;
            <span class="badge text-bg-secondary">
              {advertisement.positionLevel.name}
            </span>
            &nbsp;
            <span class="badge text-bg-secondary">
              {advertisement.contractType.name}
            </span>
            &nbsp;
            <span class="badge text-bg-secondary">
              {advertisement.workingTimeType.name}
            </span>
            &nbsp;
            <span class="badge text-bg-secondary">
              {advertisement.jobType.name}
            </span>
          </p>
        </div>
      </div>
    </div>
  );
}
