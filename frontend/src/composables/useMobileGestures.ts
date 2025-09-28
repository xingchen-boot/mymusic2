/**
 * 移动端手势支持组合式函数
 */
import { ref, onMounted, onUnmounted } from 'vue'

export interface TouchPoint {
  x: number
  y: number
  time: number
}

export interface SwipeDirection {
  direction: 'left' | 'right' | 'up' | 'down' | null
  distance: number
  velocity: number
}

export function useMobileGestures() {
  const startTouch = ref<TouchPoint | null>(null)
  const currentTouch = ref<TouchPoint | null>(null)
  const isSwipeInProgress = ref(false)
  
  // 最小滑动距离（像素）
  const minSwipeDistance = 50
  // 最大滑动时间（毫秒）
  const maxSwipeTime = 300

  const handleTouchStart = (event: TouchEvent) => {
    if (event.touches.length === 1) {
      const touch = event.touches[0]
      startTouch.value = {
        x: touch.clientX,
        y: touch.clientY,
        time: Date.now()
      }
      currentTouch.value = { ...startTouch.value }
      isSwipeInProgress.value = true
    }
  }

  const handleTouchMove = (event: TouchEvent) => {
    if (isSwipeInProgress.value && event.touches.length === 1) {
      const touch = event.touches[0]
      currentTouch.value = {
        x: touch.clientX,
        y: touch.clientY,
        time: Date.now()
      }
    }
  }

  const handleTouchEnd = (event: TouchEvent) => {
    if (isSwipeInProgress.value && startTouch.value && currentTouch.value) {
      const deltaX = currentTouch.value.x - startTouch.value.x
      const deltaY = currentTouch.value.y - startTouch.value.y
      const deltaTime = currentTouch.value.time - startTouch.value.time
      
      const distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY)
      const velocity = distance / deltaTime
      
      if (distance >= minSwipeDistance && deltaTime <= maxSwipeTime) {
        let direction: SwipeDirection['direction'] = null
        
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
          direction = deltaX > 0 ? 'right' : 'left'
        } else {
          direction = deltaY > 0 ? 'down' : 'up'
        }
        
        const swipeResult: SwipeDirection = {
          direction,
          distance,
          velocity
        }
        
        // 触发自定义事件
        const swipeEvent = new CustomEvent('swipe', { 
          detail: swipeResult 
        })
        event.target?.dispatchEvent(swipeEvent)
      }
    }
    
    isSwipeInProgress.value = false
    startTouch.value = null
    currentTouch.value = null
  }

  const addGestureListeners = (element: HTMLElement) => {
    element.addEventListener('touchstart', handleTouchStart, { passive: true })
    element.addEventListener('touchmove', handleTouchMove, { passive: true })
    element.addEventListener('touchend', handleTouchEnd, { passive: true })
  }

  const removeGestureListeners = (element: HTMLElement) => {
    element.removeEventListener('touchstart', handleTouchStart)
    element.removeEventListener('touchmove', handleTouchMove)
    element.removeEventListener('touchend', handleTouchEnd)
  }

  return {
    addGestureListeners,
    removeGestureListeners,
    isSwipeInProgress
  }
}

/**
 * 双击检测组合式函数
 */
export function useDoubleTap() {
  const lastTap = ref<number>(0)
  const tapDelay = 300 // 双击间隔时间（毫秒）

  const handleTap = (callback: () => void) => {
    const now = Date.now()
    const timeDiff = now - lastTap.value
    
    if (timeDiff < tapDelay) {
      callback()
      lastTap.value = 0
    } else {
      lastTap.value = now
    }
  }

  return {
    handleTap
  }
}

/**
 * 长按检测组合式函数
 */
export function useLongPress() {
  const longPressTimer = ref<NodeJS.Timeout | null>(null)
  const longPressDelay = 500 // 长按延迟时间（毫秒）

  const handleTouchStart = (callback: () => void) => {
    longPressTimer.value = setTimeout(() => {
      callback()
    }, longPressDelay)
  }

  const handleTouchEnd = () => {
    if (longPressTimer.value) {
      clearTimeout(longPressTimer.value)
      longPressTimer.value = null
    }
  }

  const handleTouchMove = () => {
    handleTouchEnd()
  }

  return {
    handleTouchStart,
    handleTouchEnd,
    handleTouchMove
  }
}

