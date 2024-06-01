import { useState, useEffect } from "react";
import { GetEducationLevels } from "services/api/EducationLevelService";

const useEducationLevels = () => {
  const [educationLevels, setEducationLevels] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = () => {
    setLoading(true);
    GetEducationLevels().then((res) => {
      handle(res);
    });
  };

  const handle = (res) => {
    if (res.isSuccesfull) {
      setEducationLevels(res.data);
      setLoading(false);
      return;
    }
  };

  return {
    educationLevels,
    loading,
    fetchItems,
  };
};

export default useEducationLevels;
