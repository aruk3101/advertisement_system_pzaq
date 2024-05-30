import { useState, useEffect } from "react";
import { GetAdvertisements } from "services/api/AdvertisementsService";

const useAdvertisements = (initialPage = 0, initialSize = 10) => {
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [page, setPage] = useState(initialPage);
  const [size, setSize] = useState(initialSize);
  const [totalPages, setTotalPages] = useState(0);

  useEffect(() => {
    const fetchItems = () => {
      setLoading(true);
      setError(null);
      GetAdvertisements(page, size).then((res) => {
        handle(res);
      });
    };

    fetchItems();
  }, [page, size]);

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
  };
};

export default useAdvertisements;
