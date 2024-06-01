import { useState, useEffect } from "react";
import { GetEducationLevels } from "services/api/EducationLevelService";
import { GetLanguageLevels } from "services/api/LanguageLevelService";

const useLanguageLevels = () => {
  const [languageLevels, setLanguageLevels] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = () => {
    setLoading(true);
    GetLanguageLevels().then((res) => {
      handle(res);
    });
  };

  const handle = (res) => {
    if (res.isSuccesfull) {
      setLanguageLevels(res.data);
      setLoading(false);
      return;
    }
  };

  return {
    languageLevels,
    loading,
    fetchItems,
  };
};

export default useLanguageLevels;
