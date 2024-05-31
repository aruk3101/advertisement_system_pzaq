import { useState, useEffect } from "react";
import { GetAdvertisementCategories } from "services/api/AdvertisementCategoryService";

const useAdvertisementCategories = () => {
  const [advertisementCategories, setAdvertisementCategories] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = () => {
    setLoading(true);
    GetAdvertisementCategories().then((res) => {
      handle(res);
    });
  };

  const handle = (res) => {
    if (res.isSuccesfull) {
      setAdvertisementCategories(res.data);
      setLoading(false);
      return;
    }
  };

  return {
    advertisementCategories,
    loading,
    fetchItems,
  };
};

export default useAdvertisementCategories;
