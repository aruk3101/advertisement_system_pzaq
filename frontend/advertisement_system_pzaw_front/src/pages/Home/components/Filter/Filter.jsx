import "./Filter.css";
import FilterButton from "../FilterButton/FilterButton";
import FilterModal from "../FilterModal/FilterModal";

export default function Filter({ modalId }) {
  return (
    <>
      <FilterButton modalId={modalId} />
      <FilterModal modalId={modalId} />
    </>
  );
}
