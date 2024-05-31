import { useEffect } from "react";
import { useAuth } from "hooks/useAuth";
import { EditPopupTrigger } from "components/EditPopup/EditPopup";
import useAdvertisements from "hooks/useAdvertisements";

function Advertisements() {
  const { roles } = useAuth();
  const {
    items,
    loading,
    error,
    page,
    setPage,
    size,
    setSize,
    totalPages,
    fetchItems,
  } = useAdvertisements();

  useEffect(() => {
    if (roles == null || !roles.includes("ROLE_ADMIN")) {
      return <p>Access denied.</p>;
    }
  }, [roles]);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error.message}</p>;

  return (
    <div>
      <h1 href="#">Dodaj nowe ogłoszenie</h1>
      <EditPopupTrigger variant="advertisement" refreshMethod={fetchItems} />
      <div>
        <ul>
          {items.map((item) => (
            <a href={"http://localhost:3000/advertisement/" + item.uuid}>
              <hr></hr>
              <ol>
                <li>{item.position}</li>
                <li>{item.companyName}</li>
                <li>
                  {item.salaryFrom} - {item.salaryTo}
                </li>
              </ol>
              <hr></hr>
            </a>
          ))}
        </ul>
        <div>
          <button
            onClick={() => setPage((prev) => Math.max(prev - 1, 0))}
            disabled={page === 0}
          >
            Previous
          </button>
          <span>
            Page {page + 1} of {totalPages}
          </span>
          <button
            onClick={() =>
              setPage((prev) => Math.min(prev + 1, totalPages - 1))
            }
            disabled={page === totalPages - 1}
          >
            Next
          </button>
        </div>
        <div>
          <label>
            Items per page:
            <select
              value={size}
              onChange={(e) => setSize(Number(e.target.value))}
            >
              <option value={5}>5</option>
              <option value={10}>10</option>
              <option value={20}>20</option>
            </select>
          </label>
        </div>
      </div>
    </div>
  );
}

export default Advertisements;
