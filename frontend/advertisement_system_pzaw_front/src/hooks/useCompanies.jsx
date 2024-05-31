import { useState, useEffect } from "react";
import { GetAdvertisements } from "services/api/AdvertisementsService";
import { GetCompanies } from "services/api/CompanyService";

const useCompanies = (initialPage = 0, initialSize = 10) => {
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [page, setPage] = useState(initialPage);
  const [size, setSize] = useState(initialSize);
  const [totalPages, setTotalPages] = useState(0);

  useEffect(() => {
    fetchItems();
  }, [page, size]);

  const fetchItems = () => {
    setLoading(true);
    setError(null);
    GetCompanies(page, size).then((res) => {
      handle(res);
    });
  };

  const handle = (res) => {
    if (res.isSuccesfull) {
      setItems(res.data.content);
      setTotalPages(res.data.totalPages);
      setLoading(false);
      return;
    }
  };

  return {
    items,
    loading,
    error,
    page,
    setPage,
    size,
    setSize,
    totalPages,
    fetchItems,
  };
};

export default useCompanies;
