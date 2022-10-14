package personal.ianroberts.coordinator

/**
 * Any lifecycle can implement this to host a coordinator
 *
 */
interface CoordinatorHost {
    val coordinator: Coordinator<*>
}