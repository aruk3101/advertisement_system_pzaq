import { useState, useEffect } from "react";
import { GetCompany } from "services/api/CompanyService";

const useCompany = (uuid = null) => {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [company, setCompany] = useState();

  useEffect(() => {
    if (uuid == null) return;
    fetchItems();
  }, [uuid]);

  const fetchItems = () => {
    setLoading(true);
    setError(null);
    GetCompany(uuid).then((res) => {
      console.log(res);
      handle(res);
    });
    return company;
  };

  const handle = (res) => {
    setLoading(false);
    if (res.isSuccesfull) {
      setCompany(res.data);
      return;
    } else {
      if (res.status == 404) {
        error = "Nie znaleziono ogłoszenia";
      }
    }
  };

  return {
    company,
    loading,
    setLoading,
    error,
    setError,
    fetchItems,
  };
};

export default useCompany;
