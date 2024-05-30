import { useState, useEffect } from "react";
import { GetAdvertisement } from "services/api/AdvertisementsService";

const useAdvertisement = (uuid = null) => {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [advertisement, setAdvertisement] = useState();

  useEffect(() => {
    if (uuid == null) return;
    const fetchItems = () => {
      setLoading(true);
      setError(null);
      GetAdvertisement(uuid).then((res) => {
        handle(res);
      });
    };

    fetchItems();
  }, [uuid]);

  const handle = (res) => {
    setLoading(false);
    if (res.isSuccesfull) {
      setAdvertisement(res.data);
      return;
    } else {
      if (res.status == 404) {
        error = "Nie znaleziono ogłoszenia";
      }
    }
  };

  return {
    advertisement,
    loading,
    setLoading,
    error,
    setError,
  };
};

export default useAdvertisement;
